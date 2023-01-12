<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  <xsl:template match="/">
  <html>
  <head>
    <style>
      h1{
      font-size: 3em;
      margin-left: 15%;
      margin-top: 5%;
      }
      table {
        margin-left: 15%;
        width: 70%;
      }
      table, th, td {
        border: 2px solid grey;
        border-collapse: collapse;
      }
      td, th {
        padding: 1em;
        width: 20%;
      }
      th{
        background-color: #00FFFF;
      }
      td:nth-child(1){
        text-transform: uppercase;
      }
      td:nth-child(2), td:nth-child(3){
        text-align: center;
        font-style: italic;
      }
      td:nth-child(5){
        text-align: right;
        font-weight: bolder; 
      }
      td:nth-child(5)::after{
        content: " €";
      }
    </style>
  </head>
    <body>
      <h1> Fruiteria </h1>
      <table>
        <tr>
          <th>Nom</th>
          <th>Vitamines</th>
          <th>Minerals</th>
          <th>Venda</th>
          <th>Preu per Kg</th>
        </tr>
        <xsl:for-each select="/ESTOC/FRUITA">
          <tr>
            <td><xsl:value-of select="@NOM" /></td>
            <td><xsl:value-of select="VITAMINES" /></td>
            <td><xsl:value-of select="MINERALS" /></td>
            <td><xsl:value-of select="VENDA" /></td>
            <td><xsl:value-of select="PREU_KG" /></td>
          </tr>
        </xsl:for-each>
      </table>
    </body>
  </html>  
  </xsl:template>
</xsl:stylesheet>
