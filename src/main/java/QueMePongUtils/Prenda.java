package QueMePongUtils;

import java.util.Objects;

public class Prenda {
	TipoDePrenda tipo;
	Materiales material;
	Trama trama;
	Color colorP;
	Color colorS;
	public Prenda(TipoDePrenda tipo_, Materiales material_, Trama trama_
			, Color color1, Color color2)
	{
		tipo = Objects.requireNonNull(tipo_, "Tiene que tener un tipo");
		material = Objects.requireNonNull(material_, "Tiene que estar hecha de una material");
		if ( trama_ == null)
		{
			trama = Trama.LISA;
		}
		else
		{
			trama = trama_;			
		}
		colorP = Objects.requireNonNull(color1, "Tiene que tener un color");
		colorS = color2;
	}
	public Prenda(TipoDePrenda tipo_, Materiales material_, Color color_)
	{
		this(tipo_, material_, Trama.LISA, color_, color_);
	}
	public Categorias categoria()
	{
		return tipo.categoria();
	}
}

class PseudoPrenda
{
	private TipoDePrenda tipo;
	private Materiales material;
	private Trama trama;
	private Color colorP;
	private Color colorS;
	
	public void setTipo(TipoDePrenda tipo_) 
	{
		tipo = tipo_;
	}
	public void setMateriales(Materiales material_, Trama trama_,
							  Color colorP_, Color colorS_ )
	{
		material = material_;
		trama = trama_;
		colorP = colorP_;
		colorS = colorS_;
	}
	public void setMateriales(Materiales material_, Trama trama_, Color color)
	{
		this.setMateriales(material_, trama_, color, color);
	}
	public Prenda terminarPrenda()
	{
		return new Prenda(tipo, material, trama, colorP, colorS);
	}
}

enum Trama
{
	RAYADO, LUNARES, CUADROS, LISA;
}

enum Categorias
{
	CALZADO, PARTE_SUPERIOR, PARTE_INFERIOR, ACCESORIO;
}

enum TipoDePrenda
{
	ZAPATO(Categorias.CALZADO),
	REMERA(Categorias.PARTE_SUPERIOR),
	PANTALON(Categorias.PARTE_INFERIOR),
	BOLSO(Categorias.ACCESORIO),
	SHORT(Categorias.PARTE_INFERIOR),
	CAMPERA(Categorias.PARTE_SUPERIOR);
	
	private Categorias categoria;
	
	private TipoDePrenda(Categorias categ) {
		categoria = categ;
	}
	public Categorias categoria()
	{
		return categoria;
	}
}

enum Materiales
{
	FIBRA, ALGODON, NAILON, LANA;
}

class Color 
{
	public int rojo, verde, azul;
	public Color(int rojo_, int verde_, int azul_)
	{
		rojo = rojo_; verde = verde_; azul = azul_;
	}
}
