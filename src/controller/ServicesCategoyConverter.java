/*package controller;

import java.sql.Date;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
//	public class ServicesCategoyConverter implements AttributeConverter<String, Integer> {

		@Override
		public Integer convertToDatabaseColumn(String attribute) {
			TODO Auto-generated method stub
			return null;
			return (attribute == null ? null : Integer.valueOf(attribute));
		}

		@Override
		public String convertToEntityAttribute(Integer dbData) {
			TODO Auto-generated method stub
			return null;
			return (dbData == null ? null : dbData.toLocalDate());
		}
}
*/