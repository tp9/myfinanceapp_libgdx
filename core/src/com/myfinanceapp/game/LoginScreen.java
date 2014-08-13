package com.myfinanceapp.game;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

public class LoginScreen implements Screen {
	
	private Stage stage;
	private Game game;
	Skin skin;
	
	public LoginScreen (Game g) {
		game = g;
		
		stage = new Stage();
		Gdx.input.setInputProcessor(stage);
		skin = new Skin(Gdx.files.internal("uiskin.json"));
		List<String> textFieldValues = readRecord();
		
		Label nameLabel = new Label("Name:", skin);
		final TextField nameText = new TextField(textFieldValues.get(0), skin);
		Label ageLabel = new Label("Age:", skin);
		final TextField ageText = new TextField(textFieldValues.get(1), skin);
		final TextButton textButton = new TextButton("Click Me!", skin);
		
		Table table = new Table();
		table.setFillParent(true);
		stage.addActor(table);

		table.add(nameLabel).padBottom(10).left();
		table.add(nameText).padLeft(10).padBottom(10).width(100);
		table.row();
		table.add(ageLabel).left();
		table.add(ageText).padLeft(10).width(100);
		table.row();
		table.add(textButton).padTop(20);
		stage.setKeyboardFocus(nameText);
		
		textButton.addListener(new ChangeListener() {
			public void changed (ChangeEvent event, Actor actor) {
				writeRecord(nameText.getText(), ageText.getText());
//				System.out.println("Clicked! Is checked: " + textButton.isChecked());
//				textButton.setText("Good job!");
//				infoBox("Record saved!", "SAVE RECORD");
			}
		});
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act(Gdx.graphics.getDeltaTime());
		stage.draw();		
	}

	@Override
	public void resize(int width, int height) {
		stage.getViewport().update(width, height, true);		
	}

	@Override
	public void show() {
		
	}

	@Override
	public void hide() {
		
	}

	@Override
	public void pause() {
		
	}

	@Override
	public void resume() {
		
	}

	@Override
	public void dispose() {
		
	}

	
	public void writeRecord(String name, String age) {
		try {
			FileWriter fw = new FileWriter("data.txt", false);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("name:" + name);
			bw.newLine();
			bw.write("age:" + age);
			bw.newLine();
			bw.close();
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("error" + e.getMessage());
		}
	}
	
	public List<String> readRecord() {
		List<String> returnList = new ArrayList<String>();
		
		try {
			FileReader fr = new FileReader("data.txt");
			BufferedReader br = new BufferedReader(fr);
			
			String line;
			while ((line = br.readLine()) != null) {
				String[] arr = line.split(":");
				returnList.add(arr[1]);
			}
				
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error" + e.getMessage());
		}
		
		return returnList;
	}
	
//	public static void infoBox(String infoMessage, String location) {
//		JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + location, JOptionPane.INFORMATION_MESSAGE);
//	}

}
