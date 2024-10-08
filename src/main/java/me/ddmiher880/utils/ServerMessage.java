package me.ddmiher880.utils;

public enum ServerMessage {

  OK_CREATE("Product created successfully!", false),
  OK_UPDATE("Product updated successfully!", false),
  OK_DELETE("Product deleted successfully!", false),
  
  ERROR_CREATE("ERROR: Cannot create product", true),
  ERROR_UPDATE("ERROR: Cannot update product", true),
  ERROR_DELETE("ERROR: Cannot delete product", true);

  private final String msg;
  private final boolean error;

  /**
   * Constructor con parámetros.
   * 
   * @param msg mensaje a mostrar
   * @param error indica si es un mensaje de error
   */
  ServerMessage(String msg, boolean error) {
    this.msg = msg;
    this.error = error;
  }

  /** @return true si es un error, false si no */  
  public boolean isError() {
    return error;
  }

  /** @return representación del mensaje en String */
  @Override
  public String toString() {
    return msg;
  }

}
