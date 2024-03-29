package unmsm.fisi.calidad;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import unmsm.fisi.calidad.controller.DashController;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalidadApplicationTests {

    @Autowired
    private DashController controller;

	@Test
	public void contextLoads() {
        assertThat(controller).isNotNull();
	}

    @Test
    public void gretting() throws Exception {
        final Model model = new ExtendedModelMap();
        model.addAttribute("name", "world");
        assertThat(controller.greeting("hello", model)).isNotNull();
    }

}
