package demo.teamwork.aquidigital.com.common.generate_models;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

@AutoValue
public abstract class Defaults{

	@SerializedName("privacy")
	public abstract String privacy();

	public static TypeAdapter<Defaults> typeAdapter(Gson gson) {
		return new AutoValue_Defaults.GsonTypeAdapter(gson);
	}
}