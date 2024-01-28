package az.fruitapi.controller;

import az.fruitapi.dto.FruitRequestDto;
import az.fruitapi.dto.FruitResponseDto;
import az.fruitapi.entity.Fruit;
import az.fruitapi.service.FruitService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/fruits")
public class FruitController {

    private final FruitService fruitService;

    @PostMapping("/save")
    public ResponseEntity<FruitResponseDto> save(@RequestBody FruitRequestDto requestDto) {
        return new ResponseEntity<>(fruitService.save(requestDto), HttpStatus.CREATED);
    }

    @GetMapping("findAll")
    public ResponseEntity<List<FruitResponseDto>> findAll() {
        return new ResponseEntity<>(fruitService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FruitResponseDto> findById(@PathVariable Long id) {
        return new ResponseEntity<>(fruitService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<Fruit> update(@PathVariable Long id, @RequestBody FruitRequestDto requestDto){
        return new ResponseEntity<>(fruitService.update(id, requestDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}/delete")
    public void delete(@PathVariable Long id){
        fruitService.delete(id);
    }
}
