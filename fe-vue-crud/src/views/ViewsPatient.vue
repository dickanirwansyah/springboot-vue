<template>
    <main>
        <NavBar />
        <!-- start table patient-->
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <h1 class="text-center">Views Patiens</h1>
                    <a href="/add" class="btn btn-primary">Add Patient</a>
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th scope="col">ID</th>
                                <th scope="col">NAME</th>
                                <th scope="col">EMAIL</th>
                                <th scope="col">GENDER</th>
                                <th scope="col">PHONE</th>
                                <th scope="col">ACTION</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr v-for="patient in patients" :key="patient.id">
                                <td scope="row">{{ patient.id }}</td>
                                <td scope="row">{{ patient.name }}</td>
                                <td scope="row">{{ patient.email }}</td>
                                <td scope="row">{{ patient.gender }}</td>
                                <td scope="row">{{ patient.pno }}</td>
                                <td scope="row">
                                    <a class="btn btn-primary" :href="`/edit/${patient.id}`">
                                        Edit
                                    </a>
                                    &nbsp;
                                    <button type="button" @click="$event => deletePatients(patient.id)"
                                        class="btn btn-danger">
                                        Delete
                                    </button>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <!-- end table patient-->
    </main>
</template>

<script>

import NavBar from '@/components/NavBar.vue';

export default {
    name: 'ViewsPatient',
    components: {
        NavBar
    },
    data() {
        return {
            patients: []
        }
    },
    methods: {
        getPatients() {
            fetch('http://localhost:8082/be-crud-vue/api/patient/list', {
                method: 'GET',
            })
                .then(res => res.json())
                .then(data => {
                    console.log("response list from backend ", data);
                    this.patients = data;
                })
        },

        deletePatients(id) {
            fetch(`http://localhost:8082/be-crud-vue/api/patient/delete/${id}`, {
                method: 'DELETE'
            })
                .then(data => {
                    console.log("response delete from backend ", data);
                    console.log("load new data..");
                    this.getPatients();
                });
        }
    },

    beforeMount() {
        this.getPatients();
    }
}

</script>