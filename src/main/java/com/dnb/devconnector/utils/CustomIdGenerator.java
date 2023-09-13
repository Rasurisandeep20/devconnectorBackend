//package com.dnb.devconnector.utils;
//
//import java.util.Properties;
//
//import org.hibernate.HibernateException;
//import org.hibernate.MappingException;
//import org.hibernate.engine.spi.SharedSessionContractImplementor;
//import org.hibernate.id.enhanced.SequenceStyleGenerator;
//import org.hibernate.internal.util.config.ConfigurationHelper;
//import org.hibernate.service.ServiceRegistry;
//import org.hibernate.type.Type;
//import org.hibernate.type.spi.TypeConfiguration;
//
//public class CustomIdGenerator extends SequenceStyleGenerator {
//	public static final String VALUE_PREFIX_PARAMETER = "valuePrefix";
//	public static final String VALUE_PREFIX_DEFAULT = "";
//	private String valuePrefix;
//
//	public static final String NUMBER_FORMAT_PARAMETER = "numberFormat";
//	public static final String NUMBER_FORMAT_DEFAULT = "%d";
//	private String numberFormat;
//
//	public static final boolean INCLUDE_DATE = false;
//
//	@Override
//	public Object generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
//		// Object will be of type Account
//		return valuePrefix + String.format(numberFormat, super.generate(session, object));
//	}
//
//	@Override
//	public void configure(Type type, Properties parameters, ServiceRegistry serviceRegistry) throws MappingException {
//
//		super.configure(new TypeConfiguration().getBasicTypeRegistry().getRegisteredType(Long.class), parameters,
//				serviceRegistry);
//		valuePrefix = ConfigurationHelper.getString(VALUE_PREFIX_PARAMETER, parameters, VALUE_PREFIX_DEFAULT);
//		numberFormat = ConfigurationHelper.getString(NUMBER_FORMAT_PARAMETER, parameters, NUMBER_FORMAT_DEFAULT);
//	}
//}
package com.dnb.devconnector.utils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.enhanced.SequenceStyleGenerator;
import org.hibernate.internal.util.config.ConfigurationHelper;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;
import org.hibernate.type.spi.TypeConfiguration;
public class CustomIdGenerator extends SequenceStyleGenerator {
	public static final String VALUE_PREFIX_PARAMETER = "valuePrefix";
	public static final String VALUE_PREFIX_DEFAULT = "";
	private String valuePrefix;
	public static final String NUMBER_FORMAT_PARAMETER = "numberFormat";
	public static final String NUMBER_FORMAT_DEFAULT = "%d";
	private String numberFormat;

	public static final String DATE_FORMAT_PARAMETER = "dateFormat";
	public static final String DATE_FORMAT_DEFAULT = "";
	private String dateFormat;
	//private static  boolean useDatePrefix;

	@Override
	public Object generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		// TODO Auto-generated method stub
		//System.out.println(useDatePrefix);
		if(dateFormat!=null) {
			Date currentDate = new Date();
			SimpleDateFormat dateFormatter = new SimpleDateFormat(dateFormat);
			String formattedDate = dateFormatter.format(currentDate);
			System.out.println(formattedDate);
			return valuePrefix+"_"+formattedDate+"_"+String.format(numberFormat, super.generate(session, object));
		}
		else
			return valuePrefix + String.format(numberFormat, super.generate(session, object));
	}

	@Override
	public void configure(Type type, Properties parameters, ServiceRegistry serviceRegistry) throws MappingException {
		// TODO Auto-generated method stub
		super.configure(new TypeConfiguration().getBasicTypeRegistry().getRegisteredType(Long.class), parameters, serviceRegistry);
		valuePrefix = ConfigurationHelper.getString(VALUE_PREFIX_PARAMETER, parameters,VALUE_PREFIX_DEFAULT);
		numberFormat = ConfigurationHelper.getString(NUMBER_FORMAT_PARAMETER, parameters,NUMBER_FORMAT_DEFAULT);
		dateFormat = ConfigurationHelper.getString(DATE_FORMAT_PARAMETER, parameters, DATE_FORMAT_DEFAULT);
		//useDatePrefix = Boolean.parseBoolean(parameters.getProperty("useDatePrefix","false"));
		//System.out.println(useDatePrefix);
	}
}