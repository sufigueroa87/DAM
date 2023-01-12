<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  <xsl:template match="/">
  
  <html>
  <head>
    <style>
      h1{
        font-size: 2em;
      }
      th{
        background-color: green;
        padding: 1em;
        border: 1px solid blue;
        color: white;
        font-weight: bolder;
      }
      td{
        padding: 0.5em;
      }
      table{
        margin-left: 10%;
        width: 80%;
        border-collapse: collapse;
      }
      td:nth-child(1){
        text-align: center;
        background-color: skyblue;
      }
      td:nth-child(2){
        text-align: center;
        background-color: lightyellow;
        border: 1px solid skyblue;
      }
      td:nth-child(3){
        margin-left: 2px;
        border: 1px solid lightpink;
      }
      td:nth-child(3)::before{
        content: "♡   ";
      }
    </style>
    </head>
    <body>
      <h1></h1>
      <table>
        <tr>
          <th>Dia</th>
          <th>Hora</th>
          <th>Titol</th>
        </tr>
        <xsl:for-each select="agenda/data">
          <tr>
            <td><xsl:value-of select="@dia"/></td>
            <td><xsl:value-of select="cita/@hora"/></td>
            <td><xsl:value-of select="cita/titol"/></td>
          </tr>
        </xsl:for-each>
      </table>
    </body>
  </html>
  
  </xsl:template>
</xsl:stylesheet>
