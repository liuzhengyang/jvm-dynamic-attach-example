package com.github.liuzhengyang.attach;

import com.sun.tools.attach.VirtualMachine;

/**
 * @author liuzhengyang
 */
public class Main {
    public static void main(String[] args) throws Exception {
        String pid = args[0];
        String jarFileName = args[1];
        new Main().start(pid, jarFileName);
    }

    public void start(String processId, String jarFileName) throws Exception {
        VirtualMachine virtualMachine = null;
        try {
            virtualMachine = VirtualMachine.attach(processId);
            virtualMachine.loadAgent(jarFileName);
        } finally {
            if (virtualMachine != null) {
                virtualMachine.detach();
            }
        }
    }
}
