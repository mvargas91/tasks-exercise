package co.com.testapi.util.doc;

import static org.powermock.api.mockito.PowerMockito.spy;
import static org.powermock.api.mockito.PowerMockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Class for test swagger config
 * @author milciades.vargas
 *
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(fullyQualifiedNames = "co.com.testapi.util.doc.SwaggerConfig")
public class SwaggerConfigTest {

	@InjectMocks
	SwaggerConfig swaggerConfig;
	
	@Mock
	ApiInfo apiInfo;
	
	/**
	 * Method init
	 */
    @Before
    public void setUp() {
    	MockitoAnnotations.initMocks(this);
    	swaggerConfig = spy(new SwaggerConfig());
    	apiInfo = new ApiInfoBuilder()
                .title("swagger").description("description")
                .version("1.0").build();
    }
    
    /**
     * method test for get apiInfo
     * @throws Exception
     */
    @Test
    public void getApiInfoTest() throws Exception {    	
    	when(swaggerConfig, "getApiInfo").thenReturn(apiInfo);
    	Docket docketTest = swaggerConfig.customDocket();
    	Assert.assertEquals(apiInfo.getTitle(), docketTest.getDocumentationType().getName());
    }
}
