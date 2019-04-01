async function getPokemons() {
  try {
    return await axios.get("http://localhost:8090/pokemons");
  } catch (error) {
    console.error(error);
  }
}

async function deletePokemon(id) {
  const headers = {
    Authorization: "Access-Control-Allow-Origin"
  };
  try {
    return await axios.delete("http://localhost:8090/pokemons/" + id, {
      headers
    });
  } catch (error) {
    console.error(error);
  }
}

let dados = [];
async function render() {
  try {
    const resp = await getPokemons();

    resp.data.forEach(element => {
      const { id, nome, cp, hp, doce, tipo } = element;
      dados.push({
        id,
        nome,
        cp,
        hp,
        doce,
        tipo
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
      let cp = document.createElement("td");
      cp.appendChild(document.createTextNode(el.cp));
      tr.appendChild(cp);
      // cria o nó de hp
      let hp = document.createElement("td");
      hp.appendChild(document.createTextNode(el.hp));
      tr.appendChild(hp);
      // cria o nó de doce
      let doce = document.createElement("td");
      doce.appendChild(document.createTextNode(el.doce));
      tr.appendChild(doce);
      // cria o nó de tipo
      let tipo = document.createElement("td");
      tipo.appendChild(document.createTextNode(el.tipo));
      tr.appendChild(tipo);
      // cria nó do botão de deletar
      let deletar = document.createElement("a");
      deletar.setAttribute("href", "");
      deletar.setAttribute("class", "btn red");
      let icone = document.createElement("i");
      icone.setAttribute("class", "large material-icons estilo-btn");
      icone.appendChild(document.createTextNode("delete"));
      deletar.appendChild(icone);

      deletar.addEventListener("click", e => {
        deletePokemon(el.id);
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
