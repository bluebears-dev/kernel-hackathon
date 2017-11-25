package com.hackathon.tetrisserver;

import java.io.*;

public class TetrisServer {

    private static String getJavaInstance() {
        String javaHome = System.getProperty("java.home");

        return javaHome + File.separator + "bin" + File.separator + "java";
    }

    public static void estabilishConnection(String[] args) throws IOException, InterruptedException {
        String javaInstance = TetrisServer.getJavaInstance();
        String classPath = System.getProperty("java.class.path");

        if (javaInstance.isEmpty())
            System.err.println("Could not determine JDK path.");
        else {
            Class gameInstanceClass = GameInstance.class;
            ProcessBuilder processBuilder =
                    new ProcessBuilder(javaInstance, "-cp",
                            classPath,
                            gameInstanceClass.getCanonicalName());

            processBuilder.redirectErrorStream(true);
            processBuilder.redirectOutput(ProcessBuilder.Redirect.INHERIT);
            Process gameInstance = processBuilder.start();
            System.out.println(gameInstance.waitFor());
        }
    }

    public static void main(String[] argv) throws IOException, InterruptedException {

    }
}