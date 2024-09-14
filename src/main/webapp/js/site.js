document.addEventListener('submit',
    (e) => {
        const form = e.target;
        if (form.id === 'signup-form') {
            e.preventDefault();
            let name = form.querySelector('[name="userName"]').value;
            let email = form.querySelector('[name="userEmail"]').value;
            let password = form.querySelector('[name="userPassword"]').value;
            let query = `name=${encodeURIComponent(name)}&email=${encodeURIComponent(email)}&password=${encodeURIComponent(password)}`;
            console.log(query);
  //          fetch(form.action + "?" + query, {
  //              method: 'POST'
   //         }).then(r => r.text()).then(console.log);

            fetch(form.action , {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({
                    name,
                    email,
                    password
                })
            }).then(r => r.text()).then(console.log);
        }
    })