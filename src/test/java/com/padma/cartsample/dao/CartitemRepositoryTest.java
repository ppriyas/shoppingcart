package com.padma.cartsample.dao;


        import static org.junit.Assert.assertThat;
        import static org.junit.Assert.assertTrue;

        import java.util.List;

        import javax.persistence.EntityManager;
        import javax.persistence.PersistenceContext;

        import com.padma.cartsample.dto.Cartitem;
        import org.junit.Test;
        import org.junit.runner.RunWith;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.data.domain.Sort;
        import org.springframework.data.domain.Sort.Direction;
        import org.springframework.jdbc.core.JdbcTemplate;
        import org.springframework.test.context.ActiveProfiles;
        import org.springframework.test.context.ContextConfiguration;
        import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
        import org.springframework.test.context.transaction.TransactionConfiguration;
        import org.springframework.transaction.annotation.Transactional;


@ContextConfiguration("file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml")
@ActiveProfiles("test")
@Transactional
@TransactionConfiguration(defaultRollback=true)
@RunWith(SpringJUnit4ClassRunner.class)
public class CartitemRepositoryTest {

    @Autowired private CartitemRepository cartitemRepository;

    @Autowired private JdbcTemplate jdbcTemplate;
    @PersistenceContext private EntityManager em;

    //------------------------------------------------- find all

    @Test
    public void testFindAll() {
        List<Cartitem> cartitems = cartitemRepository.findAll();
        int count = cartitems.size();
        assertTrue(count > 0);
    }


    //------------------------------------------------- insert

    @Test
    public void testInsert() {
        Cartitem another = new Cartitem();
        another.setProductName("another");
        another.setPrice(1.11);
        another.setQuantity(52);

        Cartitem cartitemInserted = cartitemRepository.save(another);
        cartitemRepository.flush();

        assertTrue(cartitemInserted.getProductName().equalsIgnoreCase("another"));
        /*String name = jdbcTemplate.queryForObject("SELECT productName FROM cartitem WHERE id = ?",
                String.class,
                cartitemInserted.getId());
        assertTrue(name.equalsIgnoreCase("another"));*/
    }


}