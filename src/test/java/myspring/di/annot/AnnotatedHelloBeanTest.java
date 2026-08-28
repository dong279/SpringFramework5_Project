package myspring.di.annot;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:hello-annot.xml")

public class AnnotatedHelloBeanTest {
	@Autowired
	//타입만 같아도되서 이렇게 작성
	HelloBean hello;
	
	@Test
	void helloBeanAnnot() {
		assertEquals("Hello 어노테이션", hello.sayHello());
	}
}
