const wrapper = document.querySelector('.wrapper');
const registerLink = document.querySelector('.register-link');
const loginLink = document.querySelector('.login-link');

registerLink.onclick = () => {
  wrapper.classList.add('active');
};

loginLink.onclick = () => {
  wrapper.classList.remove('active');
};


document.querySelectorAll('form').forEach(form => {
  form.addEventListener('submit', function(e) {
    const inputs = form.querySelectorAll('input[required]');
    let valid = true;
    inputs.forEach(input => {
      if (!input.value.trim()) {
        valid = false;
        input.classList.add('input-error'); // Opcional: marcar error visualmente
      } else {
        input.classList.remove('input-error');
      }
    });
    if (!valid) {
      e.preventDefault(); // Evita el envío del formulario
      alert('Por favor, completa todos los campos obligatorios.');
    }
  });
});