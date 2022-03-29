package com.esprit.pidevbackend.dto;

import com.esprit.pidevbackend.Game.GameModel.Player;
import lombok.Data;

@Data
public class ConnectRequest {
    private Player player;
    private String gameId;
}
