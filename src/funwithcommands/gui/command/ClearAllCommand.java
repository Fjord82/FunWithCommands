/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funwithcommands.gui.command;

import funwithcommands.gui.model.WordModel;

/**
 *
 * @author pgn
 */
public class ClearAllCommand implements ICommand
{

    private final WordModel receiver;
    private String[] state;

    public ClearAllCommand(WordModel receiver)
    {
        this.receiver = receiver;
    }

    @Override
    public void execute()
    {
        state = receiver.getWordList().toArray(new String[0]);
        receiver.getWordList().clear();
    }

    @Override
    public void undo()
    {
        for (String word : state)
        {
            receiver.addWord(word);
        }
    }

}
