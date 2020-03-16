/**
* The Following program helps us to execute operating system commands ( CommandLine Commands ) from Java Code.
*/

import java.lang.ProcessBuilder;
import java.lang.*;
import java.io.*;
import java.util.*;

class OperatingSystemCommands {
    public static void main(String args[]) throws Exception {
        Process process = new ProcessBuilder("cat","/proc/sys/fs/file-nr","| awk","\'{print $1}\'").start();
        process.waitFor();
        BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String currentLine = null, openFiles = "";
        while ((currentLine = stdInput.readLine()) != null)
        {
            openFiles+=currentLine+"\n";
        }
        System.out.print(openFiles);

        process = new ProcessBuilder("/bin/sh","-c","lsof -i 4 | sort | uniq | wc -l").start();
        process.waitFor();
        stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
        currentLine = null;
        String ipv4 = "";
        while ((currentLine = stdInput.readLine()) != null)
        {
            ipv4+=currentLine+"\n";
        }
        System.out.print(ipv4);

        process = new ProcessBuilder("/bin/sh","-c","lsof -i 6 | sort | uniq | wc -l").start();
        process.waitFor();
        stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
        currentLine = null;
        String  ipv6 = "";
        while ((currentLine = stdInput.readLine()) != null)
        {
            ipv6+=currentLine+"\n";
        }
        System.out.print(ipv6);
	}
}

