package com.myfinanceapp.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextField.TextFieldStyle;

public class LoginScreen implements Screen {
	
	private Stage stage;
	private Game game;
	Skin skin;
	
	public LoginScreen (Game g) {
		game = g;
		
		stage = new Stage();
		Gdx.input.setInputProcessor(stage);

//		skin = new Skin();
		skin = new Skin(Gdx.files.internal("uiskin.json"));
		skin.add("default", new BitmapFont());

		Pixmap pixmap = new Pixmap(1, 1, Format.RGBA8888);
		pixmap.setColor(Color.WHITE);
		pixmap.fill();
		skin.add("white", new Texture(pixmap));
		
		// Make label
		LabelStyle labelStyle = new LabelStyle();
		labelStyle.font = skin.getFont("default");
		skin.add("default", labelStyle);
		
		// Make cursor
//		skin.add("cursor", new Texture("cursor.png"));

		// Make text field
		TextFieldStyle textFieldStyle = new TextFieldStyle();
		textFieldStyle.font = skin.getFont("default");
		textFieldStyle.fontColor = Color.RED;
		textFieldStyle.background = skin.newDrawable("white", Color.LIGHT_GRAY);
		textFieldStyle.cursor = skin.newDrawable("cursor", Color.GREEN);
		skin.add("default", textFieldStyle);
		
		// Make text button
		TextButtonStyle textButtonStyle = new TextButtonStyle();
		textButtonStyle.font = skin.getFont("default");
		textButtonStyle.up = skin.newDrawable("white", Color.RED);
		textButtonStyle.down = skin.newDrawable("white", Color.BLUE);
		textButtonStyle.over = skin.newDrawable("white", Color.LIGHT_GRAY);
		skin.add("default", textButtonStyle);
		
		Label nameLabel = new Label("Name:", skin);
		TextField nameText = new TextField("", skin);
		Label ageLabel = new Label("Age:", skin);
		TextField addressText = new TextField("", skin);
		TextButton textButton = new TextButton("Click Me!", skin);
		
		Table table = new Table();
		table.setFillParent(true);
		stage.addActor(table);

		table.add(nameLabel).padBottom(10).left();
		table.add(nameText).padLeft(10).padBottom(10).width(100);
		table.row();
		table.add(ageLabel).left();
		table.add(addressText).padLeft(10).width(100);
		table.row();
		table.add(textButton).padTop(20);
		stage.setKeyboardFocus(nameText);
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

}
