package com.hong.fortune.common.converter;

import com.hong.fortune.common.utils.JacksonUtil;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.AttributeConverter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ahong
 */
public class NumberConverter implements AttributeConverter<List<Integer>, String> {
    @Override
    public String convertToDatabaseColumn(List<Integer> integers) {

        return JacksonUtil.to(integers);
    }

    @Override
    public List<Integer> convertToEntityAttribute(String s) {
        if (StringUtils.isBlank(s)) {
            return new ArrayList<>();
        }
        return JacksonUtil.fromList(s, Integer.class);
    }
}
