package com.luxury.storyteller.service;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.luxury.storyteller.dto.UserDto;
import com.luxury.storyteller.mapper.UserMapper;
import com.luxury.storyteller.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.jcodec.api.FrameGrab;
import org.jcodec.common.model.Picture;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

@Service
public class UploadService{

    @Value("${ftp.ip}")
    protected String ftpIp;

    @Value("${ftp.id}")
    protected String ftpId;

    @Value("${ftp.pwd}")
    protected String ftpPwd;
    protected static String FTP_IP;
    protected static int  FTP_PORT = 22;
    protected static String FTP_ID;
    protected static String FTP_PWD;
    static ChannelSftp chSftp = null;

    @PostConstruct
    public void init() {
        FTP_IP = ftpIp;
        FTP_ID = ftpId;
        FTP_PWD = ftpPwd;
    }

    public static void ftpOn() {

        Session ses = null;
        Channel ch  = null;
        JSch jsch   = new JSch();

        try {
            ses = jsch.getSession(FTP_ID, FTP_IP, FTP_PORT);
            ses.setPassword(FTP_PWD);

            Properties p = new Properties();
            p.put("StrictHostKeyChecking", "no");

            ses.setConfig(p);

            System.out.println("연결중");

            ses.connect();
            ch = ses.openChannel("sftp");
            ch.connect();
            chSftp = (ChannelSftp)ch;

            System.out.println("FTP 연결이 되었습니다.");

        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("FTP 연결에 실패했습니다.");
        }
    }

    public static void ftpOff() {
        try {
            chSftp.quit();
            System.out.println("FTP 연결을 종료합니다.");
        } catch(Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public String uploadFileToServer(MultipartFile file, String location) {
        ftpOn();

        String fileoriname = "";
        String fileUUID = "";

        try (InputStream in = file.getInputStream()) {
            fileoriname = file.getOriginalFilename();

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
            String today = dateFormat.format(new Date());
            fileUUID = today + "_" + fileoriname;

            chSftp.cd(location);
            chSftp.put(in, fileUUID);
            System.out.println(" 파일이름: " + fileoriname);

        } catch (Exception e) {
            e.printStackTrace();
        }

        ftpOff();

        return fileUUID;
    }


    //동영상 썸네일
    public void generateThumbnail(String videoFilePath, String thumbnailFilePath) throws IOException {

        String ffmpegPath = "C:\\ffmpeg\\bin\\ffmpeg.exe";
        //String ffmpegPath = "/usr/bin/ffmpeg";
        String[] command = {ffmpegPath, "-i", videoFilePath, "-ss", "00:00:01", "-vframes", "1", "-vf", "scale=320:320", thumbnailFilePath};

        ProcessBuilder builder = new ProcessBuilder(command);
        builder.redirectErrorStream(true);
        Process process = builder.start();

        try {
            process.waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        process.destroy();
    }

    public static String formatDuration(double seconds) {
        int hours = (int) (seconds / 3600);
        int minutes = (int) ((seconds % 3600) / 60);
        int secs = (int) (seconds % 60);

        return String.format("%02d:%02d:%02d", hours, minutes, secs);
    }

    //재생시간 구하기
    public String getVideoDuration(String videoFilePath) throws IOException {
        String ffprobePath = "C:\\ffmpeg\\bin\\ffprobe.exe";
        //String ffprobePath = "/usr/bin/ffprobe";
        String[] command = {ffprobePath, "-v", "error", "-select_streams", "v:0", "-show_entries", "stream=duration", "-of", "default=noprint_wrappers=1:nokey=1", videoFilePath};

        ProcessBuilder builder = new ProcessBuilder(command);
        builder.redirectErrorStream(true);
        Process process = builder.start();

        StringBuilder output = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line);
            }
        }

        try {
            process.waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        process.destroy();

        double durationSeconds = Double.parseDouble(output.toString().trim());

        return formatDuration(durationSeconds);
    }
}
