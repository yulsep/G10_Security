package com.misiontic.g10.securityBackend.services;

import com.misiontic.g10.securityBackend.models.Permission;
import com.misiontic.g10.securityBackend.repositories.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PermissionServices {
    @Autowired
    public PermissionRepository permissionRepository;

    /**
     * * All permissions
     */

    public List<Permission> index(){
        return  (List<Permission>) this.permissionRepository.findAll();
    }

    public Optional<Permission> show(int id){
        return this.permissionRepository.findById(id);
    }

    public Permission create(Permission newPermission){
        //Validate if id is present in json
        if(newPermission.getId() == null){
            //create
            if(newPermission.getUrl() != null && newPermission.getMethod() != null)
                return this.permissionRepository.save(newPermission);
            else {
                // TODO return 400 code BadRequest no name
                return newPermission;
            }
        }
        else {
            //TODO validate if id exist, it not create
            return newPermission;
        }
    }

    public Permission update(int id, Permission updatedPermission){
        if(id > 0){
            Optional<Permission> tempPermission = this.show(id);
            if(tempPermission.isPresent()){
                if(updatedPermission.getUrl() != null)
                    tempPermission.get().setUrl(updatedPermission.getUrl());
                return this.permissionRepository.save(tempPermission.get());
            }
            else {
                // TODO return 404 NotFound
                return updatedPermission;
            }
        }
        else {
            // TODO return 400 BadRequest, no ID
            return updatedPermission;
        }
    }

    public boolean delete(int id){
        Boolean success = this.show(id).map(permission -> {
            this.permissionRepository.delete(permission);
            return true;
        }).orElse(false);
        return success;

    }
}