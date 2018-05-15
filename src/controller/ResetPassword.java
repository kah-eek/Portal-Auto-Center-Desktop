package controller;

import com.mysql.jdbc.Util;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import utils.Utils;
import view.Main;

public class ResetPassword {

	static int userId = -1;

	// Get fields from window
	@FXML TextField txtCpf;
	@FXML PasswordField txtNovaSenha;
	@FXML DatePicker dpDtNasc;
	@FXML Button btnResetPassword;

	/**
	 * Return to mains window
	 */
	@FXML public void openMainWindow()
	{
		Main.openWindow("Main", null);
	}

	@FXML public void checkData()
	{
		// Verify if text fields are empty
		if(!txtCpf.getText().isEmpty() && !dpDtNasc.getValue().toString().isEmpty())
		{
			// Create a employee object
			Employee employee = new Employee(txtCpf.getText(), dpDtNasc.getValue().toString());

			// Verify if exists one employee with data
			userId = employee.existsEmployee(employee);

			// Active button to update password if employee exists into DB
			if(userId != -1) // Exists it
			{
				btnResetPassword.setDisable(false);
			}
			else // Not exists it
			{
				Utils.showError(null, "Redefinição de Senha", "Funcionário não encontrado !");
			}

		}
	}

	@FXML public void updatePassword()
	{
		// Verify if new password text field is empty
		if(txtNovaSenha.getText().isEmpty()) // It's empty
		{
			Utils.showWarn(null, "Redefiniço de Senha", "Preencha o campo com a nova senha!");
		}
		else  // It isn't empty
		{
			// Verify if exists employee with that data
			if(userId != -1) // Exists it
			{
				// Create a new user
				User user = new User(userId, txtNovaSenha.getText());

				// Verify if update of password has succeed
				if(user.updatePassword(user)) // Successful
				{
					Utils.showInfo(null, "Senha redefinida com sucesso!", "Redefinição de Senha");
				}
				else // Fail
				{
					Utils.showError(null, "Redefinição de Senha", "Falha ao tentar redefinir a senha do usuário :(");
				}
			}
		}
	}

	@FXML public void disableResetPasswordButton()
	{
		btnResetPassword.setDisable(true);
	}

}
