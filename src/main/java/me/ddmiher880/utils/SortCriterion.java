package me.ddmiher880.utils;

public class SortCriterion {

  private final String value;
  private final boolean descending;

  /**
   * Constructor con parámetros.
   * 
   * @param value el campo por el que se ordena (por defecto "id")
   * @param desc indica si el orden es descendente
   */
  public SortCriterion(String value, String desc) {
    this.value = value != null ? value : "id";
    this.descending = desc != null;
  }

  /** @return representación del criterio de ordenación en String */
  @Override
  public String toString() {
    return String.format(" ORDER BY %s %s", value, descending ? "DESC" : "");
  }

}
