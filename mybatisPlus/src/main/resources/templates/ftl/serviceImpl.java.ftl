package ${package.ServiceImpl};

import ${package.Entity}.${entity};
import ${package.Mapper}.${table.mapperName};
import ${package.Service}.${table.serviceName};
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ${table.serviceImplName} implements ${table.serviceName} {
	
	@Autowired
	private ${table.mapperName} ${table.entityPath}Mapper;

	

}
