package com.mytube;

public class VideoProcessor {

    private VideoEncoder encoder;
    private VideoDatabase database;
    private EmailService notification;

    public VideoProcessor(VideoEncoder encoder, VideoDatabase database, EmailService notification) {
        this.encoder = encoder;
        this.database = database;
        this.notification = notification;
    }

    public void process(Video video) {
        encoder.encode(video);
        database.store(video);
        notification.sendEmail(video.getUser());
    }
}

