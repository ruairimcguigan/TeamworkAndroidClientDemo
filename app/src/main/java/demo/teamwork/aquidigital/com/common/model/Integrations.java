package demo.teamwork.aquidigital.com.common.model;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

@AutoValue
public abstract class Integrations{

	@SerializedName("xero")
	public abstract Xero xero();

	@SerializedName("onedrivebusiness")
	public abstract Onedrivebusiness onedrivebusiness();

	@SerializedName("microsoftConnectors")
	public abstract MicrosoftConnectors microsoftConnectors();

	public static TypeAdapter<Integrations> typeAdapter(Gson gson) {
		return new AutoValue_Integrations.GsonTypeAdapter(gson);
	}
}