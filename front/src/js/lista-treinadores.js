async function getTreinadores() {
  try {
    return await axios.get("http://localhost:8090/treinadores");
  } catch (error) {
    console.error(error);
  }
}

async function deleteTreinador(id) {
  const headers = {
    Authorization: "Access-Control-Allow-Origin"
  };
  try {
    return await axios.delete("http://localhost:8090/treinadores/" + id, {
      headers
    });
  } catch (error) {
    console.error(error);
  }
}

let dados = [];
async function render() {
  try {
    const resp = await getTreinadores();

    resp.data.forEach(element => {
      const { id, nome, nivel, time} = element;
      dados.push({
        id,
        nome,
        nivel,
        time
      });
    });

    console.log(dados);
    const tbody = document.querySelector("tbody");
    console.log(tbody);
    dados.forEach(el => {
      // cria o nó de id
      let tr = document.createElement("tr");
      let id = document.createElement("td");
      id.appendChild(document.createTextNode(el.id));
      tr.appendChild(id);
      // cria o nó de nome
      let nome = document.createElement("td");
      nome.appendChild(document.createTextNode(el.nome));
      tr.appendChild(nome);
      // cria o nó de CP
      let nivel = document.createElement("td");
      nivel.appendChild(document.createTextNode(el.nivel));
      tr.appendChild(nivel);
      // cria o nó de hp
      let time = document.createElement("td");
      time.appendChild(document.createTextNode(el.time));
      tr.appendChild(time);
      // deveria criar o nó de pokemons do treinador né
      
      // cria nó do botão de deletar
      let deletar = document.createElement("a");
      deletar.setAttribute("href", "");
      deletar.setAttribute("class", "btn red");
      let icone = document.createElement("i");
      icone.setAttribute("class", "large material-icons estilo-btn");
      icone.appendChild(document.createTextNode("delete"));
      deletar.appendChild(icone);

      deletar.addEventListener("click", e => {
        deleteTreinador(el.id);
      });
      tr.appendChild(deletar);
      tbody.appendChild(tr);
    });
  } catch (error) {
    console.error(error);
  }
}

render();

// materialize initializer
document.addEventListener("DOMContentLoaded", function() {
  var elems = document.querySelectorAll(".fixed-action-btn");
  var instances = M.FloatingActionButton.init(elems);
});
