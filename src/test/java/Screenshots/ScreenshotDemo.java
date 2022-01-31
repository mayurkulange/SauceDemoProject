package Screenshots;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class ScreenshotDemo {

	public static void captureScreenshot(WebDriver driver, String screenshotName) throws IOException {
		AShot shot = new AShot();
		shot.shootingStrategy(ShootingStrategies.viewportPasting(2000));
		Screenshot screen = shot.takeScreenshot(driver);
		BufferedImage img = screen.getImage();
		ImageIO.write(img, "jpg", new File("./ScreenShots/"+screenshotName+"jpg"));
	}
}
