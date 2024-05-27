package listener;

import io.qameta.allure.Attachment;
import org.apache.log4j.Logger;
import org.testng.ITestListener;
import org.testng.ITestResult;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class TestListener implements ITestListener
{

    private static final Logger log = Logger.getLogger(TestListener.class);

    @Override
    public void onTestStart(ITestResult result) {
        log.info("=========== Start test: " + result.getMethod().getMethodName() + "===============");
    }
    
    @Override
    public void onTestSuccess(ITestResult result) {
        try
        {
            capturePNG();
        } catch(IOException e)
        {
            e.printStackTrace();
        } catch(AWTException e)
        {
            e.printStackTrace();
        }
        log.info("=========== Passed test: " + result.getMethod().getMethodName() + "===============");
    }
    
    @Override
    public void onTestFailure(ITestResult result) {
        try
        {
            capturePNG();
        } catch(IOException e)
        {
            e.printStackTrace();
        } catch(AWTException e)
        {
            e.printStackTrace();
        }
        log.info("=========== Failed test: " + result.getMethod().getMethodName() + "===============");
    }
    
    @Override
    public void onTestSkipped(ITestResult result) {
        log.info("=========== Skipped test: " + result.getMethod().getMethodName() + "===============");
    }
    
    //Text attachments for Allure
    @Attachment(value = "imageCaptured")
    public static byte[] capturePNG() throws IOException, AWTException
    {
        byte[] out = null;
        BufferedImage screencapture = new Robot().createScreenCapture(
            new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        ImageIO.write(screencapture, "png", bo);
        out = bo.toByteArray();
        bo.close();
        return out;
    }
}
