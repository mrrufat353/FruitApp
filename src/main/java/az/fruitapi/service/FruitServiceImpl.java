package az.fruitapi.service;

import az.fruitapi.dto.FruitRequestDto;
import az.fruitapi.dto.FruitResponseDto;
import az.fruitapi.entity.Fruit;
import az.fruitapi.repository.FruitRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FruitServiceImpl implements FruitService {

    private final FruitRepository fruitRepository;

    private final ModelMapper modelMapper;

    @Override
    public FruitResponseDto save(FruitRequestDto requestDto) {
        Fruit fruit = Fruit.builder()
                .amount(requestDto.getAmount())
                .name(requestDto.getName())
                .price(requestDto.getPrice())
                .build();
        Fruit fruit1 = fruitRepository.save(fruit);

        return FruitResponseDto.builder()
                .id(fruit1.getId())
                .name(fruit1.getName())
                .amount(fruit1.getAmount())
                .price(fruit1.getPrice())
                .build();
    }

    public List<FruitResponseDto> findAll() {
        return fruitRepository
                .findAll()
                .stream()
                .map(fruit -> modelMapper.map(fruit, FruitResponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public FruitResponseDto findById(Long id) {
        Fruit fruit = fruitRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fruit not found with id: " + id));
        return modelMapper.map(fruit, FruitResponseDto.class);
    }

    @Override
    public Fruit update(Long id, FruitRequestDto requestDto) {
        fruitRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fruit not found with id: " + id));
        Fruit responseFruit = modelMapper.map(requestDto, Fruit.class);
        responseFruit.setId(id);
        return modelMapper.map(fruitRepository.save(responseFruit), Fruit.class);
    }

    @Override
    public void delete(Long id) {
        Fruit fruit = fruitRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fruit not found with id: " + id));
        fruitRepository.delete(fruit);
    }
}
