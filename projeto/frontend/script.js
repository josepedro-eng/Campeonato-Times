const API = 'http://localhost:8080/times';

async function carregarTimes() {
  try {
    const resposta = await fetch(API);
    const times = await resposta.json();

    const div = document.getElementById('times');
    div.innerHTML = '';

    times.forEach(time => {
      const card = document.createElement('div');
      card.classList.add('card');

      card.innerHTML = `
        <h3>${time.nome}</h3>
        <p>${time.cidade}</p>
        <p>${time.estadio}</p>

        <div class="actions">
          <button class="edit" data-id="${time.id}">Editar</button>
          <button class="delete" data-id="${time.id}">Excluir</button>
        </div>
      `;

      div.appendChild(card);
    });

    adicionarEventos();
  } catch (error) {
    console.error('Erro ao carregar times:', error);
  }
}

function adicionarEventos() {
  document.querySelectorAll('.edit').forEach(btn => {
    btn.addEventListener('click', async (e) => {
      const id = e.target.getAttribute('data-id');
      const time = await buscarPorId(id);
      editarTime(time);
    });
  });

  document.querySelectorAll('.delete').forEach(btn => {
    btn.addEventListener('click', async (e) => {
      const id = e.target.getAttribute('data-id');
      await deletarTime(id);
    });
  });
}

async function buscarPorId(id) {
  const resposta = await fetch(`${API}/${id}`);
  return await resposta.json();
}

async function salvarTime() {
  const id = document.getElementById('timeId').value;

  const nome = document.getElementById('nome').value;
  const cidade = document.getElementById('cidade').value;
  const estadio = document.getElementById('estadio').value;

  if (!nome || !cidade || !estadio) {
    alert('Preencha todos os campos');
    return;
  }

  const time = { nome, cidade, estadio };

  const metodo = id ? 'PUT' : 'POST';
  const url = id ? `${API}/${id}` : API;

  try {
    await fetch(url, {
      method: metodo,
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(time)
    });

    limparFormulario();
    carregarTimes();
  } catch (error) {
    console.error('Erro ao salvar time:', error);
  }
}

function editarTime(time) {
  document.getElementById('timeId').value = time.id;
  document.getElementById('nome').value = time.nome;
  document.getElementById('cidade').value = time.cidade;
  document.getElementById('estadio').value = time.estadio;

  document.getElementById('form-title').innerText = 'Editar Time';
}

async function deletarTime(id) {
  try {
    await fetch(`${API}/${id}`, {
      method: 'DELETE'
    });

    carregarTimes();
  } catch (error) {
    console.error('Erro ao deletar time:', error);
  }
}

function limparFormulario() {
  document.getElementById('timeId').value = '';
  document.getElementById('nome').value = '';
  document.getElementById('cidade').value = '';
  document.getElementById('estadio').value = '';

  document.getElementById('form-title').innerText = 'Cadastrar Time';
}

carregarTimes();