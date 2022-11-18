package com.misiontic.g10.securityBackend.services;

import com.misiontic.g10.securityBackend.models.Rol;
import com.misiontic.g10.securityBackend.repositories.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolServices {
    @Autowired
    private RolRepository rolRepository;

    /**
     * * All roles
     */

    public List<Rol> index(){
        return  (List<Rol>) this.rolRepository.findAll();
    }

    public Optional<Rol> show(int id){
        return this.rolRepository.findById(id);
    }

    public Rol create(Rol newRol){
        //Validate if id is present in json
        if(newRol.getId() == null){
            //create
            if(newRol.getName() != null)
                return this.rolRepository.save(newRol);
            else {
                // TODO return 400 code BadRequest no name
                return newRol;
            }
        }
        else {
            //TODO validate if id exist, it not create
            return newRol;
        }
    }

    public Rol update(int id, Rol updatedRol){
        if(id > 0){
            Optional<Rol> tempRol = this.show(id);
            if(tempRol.isPresent()){
                if(updatedRol.getName() != null)
                    tempRol.get().setName(updatedRol.getName());
                if(updatedRol.getDescription() != null)
                    tempRol.get().setDescription(updatedRol.getDescription());
                return this.rolRepository.save(tempRol.get());
            }
            else {
                // TODO return 404 NotFound
                return updatedRol;
            }
        }
        else {
            // TODO return 400 BadRequest, no ID
            return updatedRol;
        }
    }

    public boolean delete(int id){
        Boolean success = this.show(id).map(rol -> {
            this.rolRepository.delete(rol);
            return true;
        }).orElse(false);
        return success;

    }
}
