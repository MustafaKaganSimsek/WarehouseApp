package com.api.WarehouseManagementApplication.dto.mapper;

import com.api.WarehouseManagementApplication.dto.UserDto;
import com.api.WarehouseManagementApplication.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class UserDtoConverter {

    public final CategoryDtoConverter categoryDtoConverter;
    public final ProductDtoConverter productDtoConverter;
    public UserDto convert(User from){
        return new UserDto(
                from.getId(),
                from.getName(),
                from.getEmail(),
                productDtoConverter.convert(new ArrayList<>(from.getProducts())),
                categoryDtoConverter.convert(new ArrayList<>(from.getCategories())));
    }

    public List<UserDto> convert(List<User> fromList){
        return fromList.stream().map(from -> convert(from)).collect(Collectors.toList());
    }
}
