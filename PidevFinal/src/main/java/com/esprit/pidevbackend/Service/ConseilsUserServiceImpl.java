package com.esprit.pidevbackend.Service;

import com.esprit.pidevbackend.Domain.ConseilsUser;
import com.esprit.pidevbackend.Domain.EnumLike;
import com.esprit.pidevbackend.Domain.TypeAnswer;
import com.esprit.pidevbackend.Domain.User;
import com.esprit.pidevbackend.Repository.ConseilsRepo;
import com.esprit.pidevbackend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ConseilsUserServiceImpl implements IConseilsService {
    @Autowired
    ConseilsRepo conseilsRepo;
    @Autowired
    ILikeService iLikeService;
    @Autowired
    ICommentPubService iCommentPubService;
    @Autowired
    IPublicationService iPublicationService;
    @Autowired
    UserRepository userRepository;
    @Override
    public ConseilsUser FindConseilByUser(Long idUser) {
        ConseilsUser c =conseilsRepo.FindConseilByUser(idUser);
        return c;
    }

    @Override
    public void AddConseilToUser(Long idU) {
        User a=userRepository.findById(idU).orElse(null);
        ConseilsUser u = new ConseilsUser(0,0,0,"0","0","0","0","0");
        conseilsRepo.save(u);
        a.setConseilsUser(u);
    }
    @Override
    public ConseilsUser ConseilsPersonnalisesQuiz( Long idQvt ,Long idUser) {
      //  User a=userRepository.findById(idUser).orElse(null);
       // ConseilsUser u = new ConseilsUser(0,0,0,"0","0","0","0","0");
        //a.setConseilsUser(u);
        ConseilsUser c =conseilsRepo.FindConseilByUser(idUser);
        List<TypeAnswer> typeAnswers=conseilsRepo.ListeAnswersQuizzParUser(idQvt ,idUser);
        int BAD=0;
        int Good=0;
        int Ex=0;

        for (TypeAnswer type :typeAnswers){

            if (type == TypeAnswer.BAD) {
                BAD++;
            }
            else if(type==TypeAnswer.GOOD) {
                Good++;
            }
            else if (type== TypeAnswer.EXCELLENT) {
                Ex++;
            }
        }
       int total=BAD+Good+Ex;
        if (total==0){
            total=1;
        }
        int PourCentageBAD =0;
        int PourCentageGood=0;
        int PourCentageEX =0;

         PourCentageBAD = (BAD * 100) / total ;
         PourCentageGood = (Good  * 100 )/ total;
         PourCentageEX = (Ex* 100) / total ;

        c.setPourCentageQVTBAD(PourCentageBAD);
        c.setPourCentageQVTGOOD(PourCentageGood);
        c.setPourCentageQVTEX(PourCentageEX);

        String Remarque = "null";

        if (PourCentageGood<=PourCentageEX && PourCentageBAD<=PourCentageEX){
            Remarque="Résultat remarquables , avec seulement quelques insuffiances mineures";
        }
        else if (PourCentageBAD<=PourCentageGood  && PourCentageGood >PourCentageEX){
            Remarque="Résultat Généralement Bon , malgré certaines insuffiances notables";
        }
        else {
            Remarque="Un travail supplémentaire considérable est nécessaire";
        }
        c.setRemarqueQVT(Remarque);
        List<EnumLike> l=iLikeService.getAllLikeByUser(idUser);
        int like=0,love=0,angry=0,haha=0,sad=0,wow=0;
        for (EnumLike e : l) {
            if (e == EnumLike.LIKE) {
                like++;
            }if (e == EnumLike.LOVE) {
                love++;
            }
                if (e == EnumLike.ANGRY) {
                angry++;
            }if (e == EnumLike.HAHA) {
                haha++;
            }  if (e == EnumLike.SAD) {
                sad++;
            }  if (e == EnumLike.WOW) {
                wow++;
            }
        }
        int scorelike=(like+love+haha+wow)-(angry+sad);
        if (scorelike>0){
            c.setRemarqueJaime("Vous êtes intéressé par la majorité du publication");
        }
        else
            c.setRemarqueJaime("Vous n'avez pas aimé la majorité du publication");

       int badComment= iCommentPubService.CountBedComment(idUser);
        if(badComment>=1) {
        c.setRemarqueComment("Merci de respecter la loi interne et de ne pas utiliser de gros mots");
        }
        else
            c.setRemarqueComment("Merci pour votre respect des autres dans les commentaires");
        if (iPublicationService.countAllPublicationByUser(idUser)!=0) {
            int countPub = iPublicationService.countAllPublicationByUser(idUser);
            c.setRemarquePub("J'ai fait " + countPub + " publications ");
        }
        else
            c.setRemarquePub("vous ne partage pas une publicaton");
        c.setRemarqueGenerale("tt");

        return c;
    }


}
