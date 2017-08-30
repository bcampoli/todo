package demo;

import static org.junit.Assert.assertEquals;

import java.security.Principal;

import demo.domain.Task;
import org.junit.Test;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;


public class ResourceTests {
	
	private ResourceApplication resource = new ResourceApplication();

	@Test
	public void home() {
		//assertEquals("Hello World", resource.home().getContent());
	}

	@Test
	public void changes() {
		//Principal user = new UsernamePasswordAuthenticationToken("admin", "");
		//resource.update(new Task("Foo"), user);
		//assertEquals(1, resource.changes().size());
	}

	@Test
	public void changesOverflow() {

		//Principal user = new UsernamePasswordAuthenticationToken("admin", "");
		//resource.update(new Task("Foo"), user);
		//assertEquals(10, resource.changes().size());
	}

}
