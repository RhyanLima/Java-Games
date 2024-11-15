package com.game.tictactoe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Rhyan
 */

public class TicTacToe implements ActionListener {

        private final Random random = new Random();
        private final JFrame frame = new JFrame();
        private final JPanel titlePanel = new JPanel();
        private final JPanel buttonPanel = new JPanel();
        private final JLabel textfield = new JLabel();
        private final JButton[] buttons = new JButton[9];
        private boolean player1_turn;
    
    TicTacToe(){
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
       
        // Título
        textfield.setBackground(new Color(25,25,25));
        textfield.setForeground(new Color(25,255,0));
        textfield.setFont(new Font("Ink Free",Font.BOLD,75));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Tic-Tac-Toe");
        textfield.setOpaque(true);
        
        // Painel de Título
        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBounds(0, 0, 800, 100);
        titlePanel.add(textfield);
        frame.add(titlePanel,BorderLayout.NORTH);
        frame.add(buttonPanel);
        
        // Grid do Jogo
        buttonPanel.setLayout(new GridLayout(3,3));
        buttonPanel.setBackground(new Color(150,150,150));
        
        for(int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            buttonPanel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }
        
        firstTurn();
        
    }
    
    @Override
    public void actionPerformed(ActionEvent event) {
        
        for(int i = 0; i < 9; i++) {
            if(event.getSource() == buttons[i]) {
                if(player1_turn) {
                    if(buttons[i].getText().equals("")) {
                        buttons[i].setForeground(new Color(255,0,0));
                        buttons[i].setText("X");
                        player1_turn = false;
                        textfield.setText("O Turn");
                        Check("X");
                    }
                }
                else {
                    if(buttons[i].getText().equals("")) {
                        buttons[i].setForeground(new Color(0,0,255));
                        buttons[i].setText("O");
                        player1_turn = true;
                        textfield.setText("X Turn");
                        Check("O");
                    }
                }
            }
        }
        
    }
    
    private void firstTurn() {
        
        try {
            enableButtons(false);
            Thread.sleep(1500);
            enableButtons(true);
        }
        catch (InterruptedException exeption){
            exeption.printStackTrace();
        }
        
        if(random.nextInt(2) == 0) {
            player1_turn = true;
            textfield.setText("X turn");
        } 
        else {
            player1_turn = false;
            textfield.setText("O turn");
        }
        
    }
    
    private void enableButtons(boolean state) {
        for(int i = 0; i < 9; i++) {
            buttons[i].setEnabled(state);
        }
    }
    
    private void Check(String player) {
    
        if((buttons[0].getText().equals(player)) && (buttons[1].getText().equals(player)) && (buttons[2].getText().equals(player))) { 
            if(player.equals("O")){ oWins(0,1,2); } else { xWins(0,1,2); } }
        
	if((buttons[3].getText().equals(player)) && (buttons[4].getText().equals(player)) && (buttons[5].getText().equals(player))) { 
            if(player.equals("O")){ oWins(3,4,5); } else { xWins(3,4,5); } }
        
        if((buttons[6].getText().equals(player)) && (buttons[7].getText().equals(player)) && (buttons[8].getText().equals(player))) {
            if(player.equals("O")){ oWins(6,7,8); } else { xWins(6,7,8); } }
        
        if((buttons[0].getText().equals(player)) && (buttons[3].getText().equals(player)) && (buttons[6].getText().equals(player))) { 
            if(player.equals("O")){ oWins(0,3,6); } else { xWins(0,3,6); } }
        
	if((buttons[1].getText().equals(player)) && (buttons[4].getText().equals(player)) && (buttons[7].getText().equals(player))) {
            if(player.equals("O")){ oWins(1,4,7); } else { xWins(1,4,7); } }
        
	if((buttons[2].getText().equals(player)) && (buttons[5].getText().equals(player)) && (buttons[8].getText().equals(player))) {
            if(player.equals("O")){ oWins(2,5,8); } else { xWins(2,5,8); } }
        
	if((buttons[0].getText().equals(player)) && (buttons[4].getText().equals(player)) && (buttons[8].getText().equals(player))) {
            if(player.equals("O")){ oWins(0,4,8); } else { xWins(0,4,8); } }
        
	if((buttons[2].getText().equals(player)) && (buttons[4].getText().equals(player)) && (buttons[6].getText().equals(player))) {
            if(player.equals("O")){ oWins(2,4,6); } else { xWins(2,4,6); } }
        
    }
    
    private void xWins(int a, int b, int c) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        
        enableButtons(false);
        
        textfield.setText("X Wins");
    }
    
    private void oWins(int a, int b, int c) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        
        enableButtons(false);
        
        textfield.setText("O Wins");
    }
}
