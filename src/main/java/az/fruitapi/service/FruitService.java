package az.fruitapi.service;

import az.fruitapi.dto.FruitRequestDto;
import az.fruitapi.dto.FruitResponseDto;
import az.fruitapi.entity.Fruit;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FruitService {

    FruitResponseDto save(FruitRequestDto requestDto);

    List<FruitResponseDto> findAll();

    FruitResponseDto findById(Long id);

    Fruit update(Long id, FruitRequestDto requestDto);

    void delete(Long id);
}
