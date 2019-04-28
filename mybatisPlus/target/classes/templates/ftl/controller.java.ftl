package ${package.Controller};

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import ${package.Service}.${table.serviceName};

@Controller
@RequestMapping("/${table.entityPath}")
public class ${table.controllerName} {

	@Autowired
	private ${table.serviceName} ${table.entityPath}Service;
	
	

}
