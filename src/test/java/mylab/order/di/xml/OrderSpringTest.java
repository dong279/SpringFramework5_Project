package mylab.order.di.xml;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:mylab-order-di.xml")
public class OrderSpringTest {
	
	@Autowired
	ShoppingCart shoppingCart;
	
	@Resource(name="orderService")
	OrderService orderService;
	
	@Resource(name = "product1")
	Product product1;

	@Resource(name = "product2")
	Product product2;
	
	@Test
	void testShoppingCart() {
		assertNotNull(shoppingCart);
		assertEquals(2,shoppingCart.getProducts().size());
		assertEquals("노트북", shoppingCart.getProducts().get(0).getName());
		assertEquals("스마트폰", shoppingCart.getProducts().get(1).getName());
	}
	
	@Test
	void OrderService() {
		assertNotNull(orderService);
		assertNotNull(orderService.getShoppingCart()); 
		assertEquals(950000.0,orderService.calculateOrderTotal());
		
	}
	@Test
	void testProducts() {
		assertEquals("P001", product1.getId());
		assertEquals(150000.0, product1.getPrice());

		assertEquals("P002", product2.getId());
		assertEquals(800000.0, product2.getPrice());

		assertSame(product1, shoppingCart.getProducts().get(0));
	}
}
