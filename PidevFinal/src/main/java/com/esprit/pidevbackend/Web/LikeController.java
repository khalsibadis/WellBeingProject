package com.esprit.pidevbackend.Web;


import com.esprit.pidevbackend.Domain.EnumLike;
import com.esprit.pidevbackend.Domain.LikePub;

import com.esprit.pidevbackend.Service.ILikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Like")

public class LikeController {
    @Autowired
    ILikeService iLikeService ;
   // @Secured({"ROLE_USER","ROLE_ADMIN"})

    @PostMapping("/post/{idU}/{idP}")
    public void AddLikePub (@RequestBody LikePub e, @PathVariable("idU") Long idUser,@PathVariable("idP") Long idPub){
        iLikeService.AddLikePub(e, idUser, idPub);
    }
   // @Secured({"ROLE_USER","ROLE_ADMIN"})

    @GetMapping("/Get")
    public List<LikePub> getAllLikePub(){
        return iLikeService.getAllLikePub();
    }
   // @Secured({"ROLE_USER","ROLE_ADMIN"})

    @DeleteMapping("/Delete/{id}")
    public void DeleteLikePub (@PathVariable("id") Long id){
        iLikeService.DeleteLikePub(id);
    }
   // @Secured({"ROLE_USER","ROLE_ADMIN"})

    @PutMapping("/put")
    public void UpdateLikePub (LikePub e){
        iLikeService.UpdateLikePub(e);
    }
   // @Secured({"ROLE_USER","ROLE_ADMIN"})

    @GetMapping("/getallLikeByPub/{id}")
    public List<EnumLike> getAllLikeByPub (@PathVariable("id") Long idPub){
        return iLikeService.getAllLikeByPub(idPub);
    }
   // @Secured({"ROLE_USER","ROLE_ADMIN"})

    @GetMapping("/getAllLikeByUser/{id}")
    public List<EnumLike> getAllLikeByUser (@PathVariable("id") Long idUserb){
        return iLikeService.getAllLikeByUser(idUserb);
    }
   // @Secured({"ROLE_USER","ROLE_ADMIN"})

    @GetMapping("/countAllLikeByPub/{id}")
    public int countAllLikeByPub(@PathVariable("id") Long idPub){
        return iLikeService.countAllLikeByPub(idPub);
    }
   // @Secured({"ROLE_USER","ROLE_ADMIN"})

    @GetMapping("/allLikeByUser/{id}")
    public List<EnumLike> getAllLikeByPubByUser (@PathVariable("id") Long idUser){
        return iLikeService.getAllLikeByPubByUser(idUser);
    }
}
