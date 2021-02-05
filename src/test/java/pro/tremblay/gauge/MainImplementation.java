package pro.tremblay.gauge;

import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.datastore.SpecDataStore;
import com.thoughtworks.gauge.datastore.SuiteDataStore;
import pro.tremblay.app.Main;
import org.assertj.swing.core.BasicRobot;
import org.assertj.swing.core.Robot;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.launcher.ApplicationLauncher;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.swing.finder.WindowFinder.findFrame;
import static org.assertj.swing.launcher.ApplicationLauncher.application;

public class MainImplementation {

    private Robot robot() {
        return (Robot) SpecDataStore.get("robot");
    }

    @BeforeScenario
    public void before() {
        System.out.println("Before");
        ApplicationLauncher app = application(Main.class);
        app.start();

        Robot robot = BasicRobot.robotWithCurrentAwtHierarchy();
        robot.settings().delayBetweenEvents(10);
        robot.settings().eventPostingDelay(10);

        SpecDataStore.put("robot", robot);
    }

    @AfterScenario
    public void after() {
        System.out.println("After");
        if(robot() != null) {
            robot().cleanUp();
        }
        SuiteDataStore.remove("robot");
    }

    @Step("Test")
    public void test() {
        System.out.println("Test " + Objects.hash(this));

        FrameFixture mainFrame = findFrame("Test").using(robot());
        assertThat(mainFrame).isNotNull();
        mainFrame.close();
    }
}
