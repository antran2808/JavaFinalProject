package vn.edu.tdt.finalproject.repositories.mappers;

import vn.edu.tdt.finalproject.repositories.entities.estates.Estate;
import vn.edu.tdt.finalproject.repositories.entities.estates.EstateDTO;
import vn.edu.tdt.finalproject.repositories.enums.EstateStatusEnum;

public class EstateMapper implements IEntityMapper<EstateDTO, Estate> {

    @Override
    public EstateDTO convertEntity(Estate entity) throws Exception {
        EstateDTO res = new EstateDTO();
        res.setId(entity.getId());
        res.setName(entity.getName());
        res.setImages(entity.getImages());
        res.setDescription(entity.getDescription());
        res.setPublicDate(entity.getPublicDate());
        res.setOwnerId(entity.getOwnerId());
        res.setSellPrice(entity.getSellPrice());
        res.setRentPrice(entity.getRentPrice());
        res.setAddress(entity.getAddress());
        res.setStatus(entity.getStatus().ordinal());
        return res;
    }

    @Override
    public Estate convertEntityDTO(EstateDTO entity) throws Exception {
        Estate res = new Estate();
        res.setId(entity.getId());
        res.setName(entity.getName());
        res.setImages(entity.getImages());
        res.setDescription(entity.getDescription());
        res.setPublicDate(entity.getPublicDate());
        res.setOwnerId(entity.getOwnerId());
        res.setSellPrice(entity.getSellPrice());
        res.setRentPrice(entity.getRentPrice());
        res.setAddress(entity.getAddress());
        res.setStatus(EstateStatusEnum.get(entity.getStatus()));
        return res;
    }

}
