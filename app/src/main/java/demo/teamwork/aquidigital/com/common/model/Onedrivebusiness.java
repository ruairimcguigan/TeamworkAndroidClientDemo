package demo.teamwork.aquidigital.com.common.model;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

@AutoValue
public abstract class Onedrivebusiness{

	@SerializedName("folder")
	public abstract String folder();

	@SerializedName("foldername")
	public abstract String folderName();

	@SerializedName("enabled")
	public abstract boolean isEnabled();

	@SerializedName("account")
	public abstract String account();

	public static TypeAdapter<Onedrivebusiness> typeAdapter(Gson gson) {
		return new AutoValue_Onedrivebusiness.GsonTypeAdapter(gson);
	}
}