import com.itheima.mapper.TabRouteMapper;
import com.itheima.page.service.impl.RoutePageServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:spring/applicationContext-*.xml")
public class test {

    @Autowired
    private RoutePageServiceImpl routePageService;

    @Test
    public   void  testGetHtml(){
        routePageService.getRouteHtml(11);
    }


}
