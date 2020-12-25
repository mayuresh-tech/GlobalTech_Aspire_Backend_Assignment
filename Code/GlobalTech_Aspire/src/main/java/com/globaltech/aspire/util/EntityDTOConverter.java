package com.globaltech.aspire.util;

import com.globaltech.aspire.dto.CompanyDTO;
import com.globaltech.aspire.dto.TagsDTO;
import com.globaltech.aspire.dto.UserDTO;
import com.globaltech.aspire.entity.Company;
import com.globaltech.aspire.entity.Tags;
import com.globaltech.aspire.entity.User;
import com.google.common.reflect.TypeToken;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.NamingConventions;

import java.util.Arrays;

@SuppressWarnings("serial")
public class EntityDTOConverter {

    private EntityDTOConverter() {
    }

    private static final String ENTRIES_DELIMITER = ",";

    private static ModelMapper getUserDTOMapper() {
        ModelMapper mapper = new ModelMapper();
        mapper.addMappings(new PropertyMap<User, UserDTO>() {
            @Override
            protected void configure() {
                skip(destination.getPassword());
            }
        });
        return mapper;
    }

    public static UserDTO getUserDTOFromEntity(User user) {
        return getUserDTOMapper().map(user, UserDTO.class);
    }

    private static ModelMapper getCompanyDTOMapper() {
        ModelMapper mapper = new ModelMapper();
        mapper.addMappings(new PropertyMap<Company, CompanyDTO>() {
            @Override
            protected void configure() {
            }
        });
        return mapper;
    }

    public static CompanyDTO getCompanyDTOFromEntity(Company company) { return getCompanyDTOMapper().map(company, CompanyDTO.class); }


    public static TagsDTO getTagsDTOFromEntity(Tags tags) {
        ModelMapper tagsMapper = new ModelMapper();
        tagsMapper.getConfiguration().setFieldMatchingEnabled(true).setFieldAccessLevel(Configuration.AccessLevel.PRIVATE)
                .setSourceNamingConvention(NamingConventions.JAVABEANS_MUTATOR);
        tagsMapper.typeMap(Tags.class, TagsDTO.class).setPostConverter(context -> {
            return context.getDestination();
        });

        return tagsMapper.map(tags, new TypeToken<TagsDTO>() {
        }.getType());
    }
}
