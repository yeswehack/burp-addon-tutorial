package burp

import java.io.PrintWriter

@Suppress("unused") // Remove warning, the class will be used by burp
class BurpExtender : IBurpExtender {
    override fun registerExtenderCallbacks(callbacks: IBurpExtenderCallbacks) {
        // Let's wrap stdout and stderr in PrintWriter with auto flush
        val stdout = PrintWriter(callbacks.stdout,  true)
        val stderr = PrintWriter(callbacks.stderr,  true)

        // Set our extension name, this will be display in burp extensions tab
        callbacks.setExtensionName("My Addon")

        stdout.println("Hello world!")
        stderr.println("Hello error!")
    }
}