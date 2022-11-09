package guru.springframework.service.impl;

import guru.springframework.commands.UnitOfMeasureCommand;
import guru.springframework.converters.UnitOfMeasureToUnitOfMeasureCommand;
import guru.springframework.repositories.UnitOfMeasureRepository;
import guru.springframework.service.UnitOfMeasureService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UnitOfMeasureServiceImpl implements UnitOfMeasureService {

    private final UnitOfMeasureRepository unitOfMeasureRepository;
    private final UnitOfMeasureToUnitOfMeasureCommand converter;

    @Override
    public Set<UnitOfMeasureCommand> listAllUoms() {
        return unitOfMeasureRepository.findAll().stream().map(converter::convert).collect(Collectors.toSet());
    }
}
